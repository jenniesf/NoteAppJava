// 1. Cookie
    // we know that we now have a cookie we need to read to get the logged in user’s Id
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];

if (!userId) {  // check if there is a user logged in, if not, redirect to login page instead of home page
     window.location.replace("http://localhost:8080/login.html")
}

// DOM Elements
const submitForm = document.getElementById("note-form")
const noteContainer = document.getElementById("note-container")

// Modal Elements
let noteBody = document.getElementById(`note-body`)
let updateNoteBtn = document.getElementById('update-note-button')

const headers = {
    'Content-Type' : 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/notes/'

// 2. B/c we have a logged in user and we are keeping track with a cookie, we will need a logout method that clears that cookie
    // html has a 'onClick'
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

// 3. Form that submits new notes
const handleSubmit = async (e) => {
    e.preventDefault() //prevent default behavior of the form
    let bodyObj = {
        body: document.getElementById("note-input").value  // store note-input value
    }
    await addNote(bodyObj);  // run addNote function below
    document.getElementById("note-input").value = ''  // update note-input value to empty
}

async function addNote(obj) {
    const response = await fetch(`${baseUrl}user/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    if (response.status == 200) {
        return getNotes(userId); // run getNotes function below
    }
}

// 4. Retrieve all the notes that are associated with the user when the page loads, create cards for them, and append them to a container to hold them
async function getNotes(userId) {
    await fetch(`${baseUrl}user/${userId}`, {
        method: "GET",
        headers: headers
    })
        .then(response => response.json())
        .then(data => createNoteCards(data))  // run create notes cards below (helper function)
        .catch(err => console.error(err))
}

// 5. Update a note which will involve a separate GET request for just that note so we can populate our modal with it
async function getNoteById(noteId){                // GET current note body before updates/edits to populate in modal
    await fetch(baseUrl + noteId, {
        method: "GET",
        headers: headers
    })
        .then(res => res.json())
        .then(data => populateModal(data))  // run populate modal below (helper function)
        .catch(err => console.error(err.message))
}

async function handleNoteEdit(noteId){   // runs onClick
    let bodyObj = {
        id: noteId,
        body: noteBody.value
    }

    await fetch(baseUrl, {
        method: "PUT",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err))

    return getNotes(userId);   // run getNotes above
}

// 6. Delete a note
async function handleDelete(noteId){
    await fetch(baseUrl + noteId, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    return getNotes(userId);
}

// HELPER FUNCTIONS

// accepts an array of objects. It then loops through the array and
    // creates a little note card for each item and appends it to our container for the notes.
const createNoteCards = (array) => {
    noteContainer.innerHTML = ''
    array.forEach( obj => {
        let noteCard = document.createElement("div")
        noteCard.classList.add("m-2")
        noteCard.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 18rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                    <p class="card-text">${obj.body}</p>
                    <div class="d-flex justify-content-between">

                        <button class="btn btn-danger" onclick="handleDelete(${obj.id})">Delete</button>

                        <button onclick="getNoteById(${obj.id})" type="button" class="btn btn-primary"
                        data-bs-toggle="modal" data-bs-target="#note-edit-modal">
                        Edit
                        </button>

                    </div>
                </div>
            </div>
        `
        noteContainer.append(noteCard);
    })
}

// “populateModal” method which accepts an object as an argument and uses that object to populate the fields
    // within the modal as well as assign a custom “data-” tag to the “Save” button element
const populateModal = (obj) =>{
    noteBody.innerText = ''
    noteBody.innerText = obj.body
    updateNoteBtn.setAttribute('data-note-id', obj.id)
}

// The last steps were to invoke the getNotes method, add two Event Listeners in the JavaScript,
// and add one “onclick” attributes to the logout button in the HTML file
getNotes(userId);

submitForm.addEventListener("submit", handleSubmit)

updateNoteBtn.addEventListener("click", (e)=>{
    let noteId = e.target.getAttribute('data-note-id')
    handleNoteEdit(noteId);
})






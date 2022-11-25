const loginForm = document.getElementById('login-form')
const loginUsername = document.getElementById('login-username')
const loginPassword = document.getElementById('login-password')

const headers = {
    'Content-Type' : 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users'

const handleSubmit = async (e) => {

    //prevent default behavior of the form
    e.preventDefault()

    // grab the value’s of the inputs and store them inside of an
        // object that can then be used as the body for the POST request
    let bodyObj = {
        username: loginUsername.value,
        password: loginPassword.value
    }

    // make the request and handle the response accordingly.
    // For quality of life we can also edit our UserServiceImpl to return a
    // redirect URL string rather than the registration success message.
    // When a User successfully registers, we can send back the URL for the
    // Login page and then in our JavaScript we can redirect the window to the URL we received in the response.
    const response = await fetch( `${baseUrl}/login` , {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200 ) {
        // create a JavaScript cookie to be able to store the user’s Id for subsequent requests once they’re logged in
        document.cookie = `userId=${responseArr[1]}`
        window.location.replace(responseArr[0])
    }
}

// add our event listener to our form, we want our form to listen for the “submit” event and to invoke this handleSubmit function
loginForm.addEventListener("submit" , handleSubmit )
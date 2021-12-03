function nice_func(){
  const xhr = new XMLHttpRequest();

// listen for `load` event
xhr.onload = () => {

    // print JSON response
    if (xhr.status >= 200 && xhr.status < 300) {
        // parse JSON
        const response = JSON.parse(xhr.responseText);
        console.log(response);
    }
};

// create a JSON object
const json = {
    "num": 7,
    "bname": "cityslicka",
    "price": 88
};

// open request
xhr.open('POST', 'http://localhost:8081/api/v1/Book');

// set `Content-Type` header
xhr.setRequestHeader('Content-Type', 'application/json');

// send rquest with JSON payload
xhr.send(JSON.stringify(json));
}
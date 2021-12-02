const data = {id: 3, Name: "Eragon", Price: 6.99};

fetch("http://localhost:8080/api/v1/Book", {
  method: "POST",
  headers: {'Content-Type': 'application/json'},
  body: JSON.stringify(data)
}).then(res => res.json())
.then(res => console.log(res));
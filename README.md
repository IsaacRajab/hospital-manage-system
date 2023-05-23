
# ----------------------------doctor-----------------------------
<!DOCTYPE html>
<html>
<head>

</head>
<body>
  <table>
    <thead>
      <tr>
        <th style="background-color:cornflowerblue">HTTP Method</th>
        <th style="background-color:cornflowerblue">URL Path</th>
        <th style="background-color:cornflowerblue">HTTP Status Code</th>
        <th style="background-color:cornflowerblue">Description</th>
        <th style="background-color:cornflowerblue">Sample Request</th>
        <th style="background-color:cornflowerblue">Sample Response</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>GET</td>
        <td>/doctors/{id}</td>
        <td>200 OK</td>
        <td>Get doctor by ID</td>
        <td><code>GET /doctors/{id}</code></td>
        <td><code>200 OK</code><br>{ "id": 1, "name": "John Doe", "specialization": "Cardiology" }</td>
      </tr>
      <tr>
        <td>POST</td>
        <td>/doctors</td>
        <td>201 Created</td>
        <td>Create a new doctor</td>
        <td><code>POST /doctors</code></td>
        <td><code>201 Created</code><br>{ "id": 2, "name": "Jane Smith", "specialization": "Pediatrics" }</td>
      </tr>
      <tr>
        <td>PUT</td>
        <td>/doctors/{id}</td>
        <td>200 OK</td>
        <td>Update doctor by ID</td>
        <td><code>PUT /doctors/{id}</code></td>
        <td><code>200 OK</code><br>{ "id": 1, "name": "John Doe", "specialization": "Cardiology" }</td>
      </tr>
      <tr>
        <td>DELETE</td>
        <td>/doctors/{id}</td>
        <td>204 No Content</td>
        <td>Delete doctor by ID</td>
        <td><code>DELETE /doctors/{id}</code></td>
        <td><code>204 No Content</code></td>
      </tr>
    </tbody>
  </table>
</body>
</html>

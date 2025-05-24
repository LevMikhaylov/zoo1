<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Guardian</title>
    <style>
        .form-group { margin-bottom: 15px; }
        .error { color: red; }
    </style>
</head>
<body>
    <h1>Edit Guardian</h1>
    
    <form action="/guardians/update/${guardian.id}" method="post">
        <input type="hidden" name="id" value="${guardian.id}">
        
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${guardian.name!''}" required>
        </div>
        
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="text" id="surname" name="surname" value="${guardian.surname!''}" required>
        </div>
        
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" value="${guardian.email!''}" required>
        </div>
        
        <div class="form-group">
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" value="${guardian.phoneNumber!''}" required>
        </div>
        
        <button type="submit">Update Guardian</button>
    </form>
    
    <a href="/guardians/all">Back to list</a>
</body>
</html>
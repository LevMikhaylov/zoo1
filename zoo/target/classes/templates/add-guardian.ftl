<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Guardian</title>
    <style>
        .form-group { margin-bottom: 15px; }
        .error { color: red; }
    </style>
</head>
<body>
    <h1>Add New Guardian</h1>
    
    <form action="/guardians/add" method="post">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        
        <div class="form-group">
            <label for="surname">Surname:</label>
            <input type="text" id="surname" name="surname" required>
        </div>
        
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        
        <div class="form-group">
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" id="phoneNumber" name="phoneNumber" required>
        </div>
        
        <button type="submit">Hire Guardian</button>
    </form>
    
    <a href="/guardians/all">Back to list</a>
</body>
</html>
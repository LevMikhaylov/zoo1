<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Enclosure</title>
    <style>
        .form-group { margin-bottom: 15px; }
        .error { color: red; }
    </style>
</head>
<body>
    <h1>Add New Enclosure</h1>
    
    <form action="/enclosures/add" method="post">
        <div class="form-group">
            <label for="id">Enclosure ID:</label>
            <input type="number" id="id" name="id" required>
        </div>
        
        <button type="submit">Add Enclosure</button>
    </form>
    
    <a href="/enclosures/all">Back to list</a>
</body>
</html>
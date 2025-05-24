<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Animal</title>
    <style>
        .form-group { margin-bottom: 15px; }
        .error { color: red; }
    </style>
</head>
<body>
    <h1>Edit Animal</h1>
    
    <form action="/animals/${animal.id}" method="post">
        <input type="hidden" name="_method" value="PUT">
        
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" 
                   value="${animal.name!''}" required>
            <#if nameError??><span class="error">${nameError}</span></#if>
        </div>
        
        <div class="form-group">
            <label for="kind">Kind:</label>
            <input type="text" id="kind" name="kind" 
                   value="${animal.kind!''}" required>
            <#if kindError??><span class="error">${kindError}</span></#if>
        </div>
        
        <button type="submit">Update Animal</button>
    </form>
    
    <a href="/animals/allAnimals">Back to list</a>
</body>
</html>
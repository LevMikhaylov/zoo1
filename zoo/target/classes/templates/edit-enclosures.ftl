<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Enclosure</title>
    <style>
        .form-group { margin-bottom: 15px; }
        .error { color: red; }
    </style>
</head>
<body>
    <h1>Edit Enclosure</h1>
    
    <form action="/enclosures/update/${enclosure.id}" method="post">
        <input type="hidden" name="id" value="${enclosure.id}">
        
        <div class="form-group">
            <label>Current Animals:</label>
            <ul>
                <#list enclosure.animals as animal>
                    <li>${animal.name} (${animal.kind})</li>
                </#list>
            </ul>
        </div>
        
        <button type="submit">Update Enclosure</button>
    </form>
    
    <a href="/enclosures/all">Back to list</a>
</body>
</html>
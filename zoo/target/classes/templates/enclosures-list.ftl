<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Enclosures</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .actions a { margin-right: 10px; }
    </style>
</head>
<body>
    <h1>Enclosures List</h1>
    
    <a href="/enclosures/add">Add New Enclosure</a>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Animals Count</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <#list enclosures as enclosure>
            <tr>
                <td>${enclosure.id}</td>
                <td>${enclosure.animals?size}</td>
                <td class="actions">
                    <a href="/enclosures/edit/${enclosure.id}">Edit</a>
                    <a href="/enclosures/delete/${enclosure.id}" 
                       onclick="return confirm('Are you sure you want to delete this enclosure?')">Delete</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
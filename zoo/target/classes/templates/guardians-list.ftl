<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>All Guardians</title>
    <style>
        table { width: 100%; border-collapse: collapse; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
        .actions a { margin-right: 10px; }
    </style>
</head>
<body>
    <h1>Guardians List</h1>
    
    <a href="/guardians/add">Add New Guardian</a>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Surname</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <#list guardians as guardian>
            <tr>
                <td>${guardian.id}</td>
                <td>${guardian.name}</td>
                <td>${guardian.surname}</td>
                <td>${guardian.email}</td>
                <td>${guardian.phoneNumber}</td>
                <td class="actions">
                    <a href="/guardians/edit/${guardian.id}">Edit</a>
                    <a href="/guardians/delete/${guardian.id}" 
                       onclick="return confirm('Are you sure you want to delete this guardian?')">Delete</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
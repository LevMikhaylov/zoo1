<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>All Animals</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .action-links a {
            margin-right: 10px;
            text-decoration: none;
            color: #0066cc;
        }
        .alert {
            padding: 15px;
            margin-bottom: 20px;
            border: 1px solid transparent;
            border-radius: 4px;
        }
        .alert-success {
            color: #3c763d;
            background-color: #dff0d8;
            border-color: #d6e9c6;
        }
        .alert-danger {
            color: #a94442;
            background-color: #f2dede;
            border-color: #ebccd1;
        }
    </style>
</head>
<body>
    <h1>All Animals</h1>
    
    <#if message??>
    <div class="alert alert-success">
        ${message}
    </div>
    </#if>
    
    <#if error??>
    <div class="alert alert-danger">
        ${error}
    </div>
    </#if>
    
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Kind</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <#list animals as animal>
            <tr>
                <td>${animal.id}</td>
                <td>${animal.name}</td>
                <td>${animal.kind}</td>
                <td class="action-links">
                    <a href="/animals/edit/${animal.id}">Edit</a>
                    <a href="#" onclick="confirmDelete(${animal.id})">Delete</a>
                </td>
            </tr>
            </#if>
        </tbody>
    </table>
    
    <div style="margin-top: 20px;">
        <a href="/animals/add">Add New Animal</a>
    </div>

    <script>
        function confirmDelete(id) {
            if (confirm('Are you sure you want to delete this animal?')) {
                fetch(`/animals/delete/${id}`, {
                    method: 'DELETE',
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
                .then(response => {
                    if (response.ok) {
                        window.location.href = '/animals/allAnimals?message=Animal+deleted+successfully';
                    } else {
                        window.location.href = '/animals/allAnimals?error=Error+deleting+animal';
                    }
                })
                .catch(error => {
                    window.location.href = '/animals/allAnimals?error=Error+deleting+animal';
                });
            }
        }
    </script>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zoo Animals</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
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
        form {
            margin-bottom: 20px;
            padding: 15px;
            background-color: #f5f5f5;
            border-radius: 5px;
        }
        input, button {
            padding: 8px;
            margin: 5px 0;
        }
        .actions {
            display: flex;
            gap: 5px;
        }
        a {
            text-decoration: none;
            color: #0066cc;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Zoo Animals Management</h1>
    
    <!-- Форма для добавления нового животного -->
    <form action="/animals/add" method="post">
        <h2>Add New Animal</h2>
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="kind">Kind:</label>
            <input type="text" id="kind" name="kind" required>
        </div>
        <button type="submit">Add Animal</button>
    </form>
    
    <!-- Таблица с животными -->
    <h2>Animals List</h2>
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
                    <td class="actions">
                        <a href="/animals/updatedAnimals">Edit</a>
                        <a href="/animals/delete">Delete</a>
                    </td>
                </tr>
            </#list>
        </tbody>
    </table>
</body>
</html>
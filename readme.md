# Java ToDo API example


----
## Endpoints

### /todos

#### Get: 

List ToDos
##### Response:

```js
[
    {
        "description": "To do description",
        "id": "to do uuid", // e.g. "cdfffde7-97e7-4f05-b9d4-c4c27f45e5d7",
        "done": false || true
    }
]
```

### /todo

#### Post:

Create ToDo
##### Body:

```js
{
    "description": "ToDo desciption"
}
```

##### Response:

```js
{
    "description": "ToDo description",
    "id": "to do uuid", // e.g. "cdfffde7-97e7-4f05-b9d4-c4c27f45e5d7"
    "done": false || true
}
```

### /todo/{todoid}

#### Put:

Updates ToDo

##### Body:

```js 
{
    "description": "New description",
    "done": true || false
}
```

##### Response: 

```js
{
    "description": "New description",
    "done": true || false,
    "id": "ToDo UUID" // e.g. "cdfffde7-97e7-4f05-b9d4-c4c27f45e5d7"
}
```

#### Delete:

Deletes a ToDo

##### Response:

```js
{
    "description": "Deleted ToDo description",
    "done": true || false,
    "id": "ToDo UUID" // e.g. "cdfffde7-97e7-4f05-b9d4-c4c27f45e5d7"
}
```



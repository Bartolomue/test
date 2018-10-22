# beers


### Endpoints

Returns all beers which any food pairing contains provided phrase
```
GET
/foodpairings/search/{phrase}
```

Save and update beers passed as list of dtos
```
POST
/beers
```

### Security

Basic authorization by following properties:

```
user: user
password: pass1234
```
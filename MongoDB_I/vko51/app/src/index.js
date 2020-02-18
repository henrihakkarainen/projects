const express = require('express')
const MongoClient = require('mongodb').MongoClient
const ObjectID = require('mongodb').ObjectID

const mongoUrl = 'mongodb://db:27017/'
let db, collection

var app = express()
app.use(express.json())
app.use(express.urlencoded({ extended : true }))

app.listen(9000, () => {
    console.log('Server listening on port 9000.')
    MongoClient.connect(mongoUrl, {useNewUrlParser : true}, (err, client) => {
        if (err) throw err
        db = client.db('company')
        collection = db.collection('employees')
        console.log(`Connected to database ${db.databaseName}!`)

    })
})

app.post('/employees', (req, res) => {
    console.log(req.body)
    collection.insert(req.body, (err, result) => {
        if (err) return res.status(500).send(err)
        res.send(result.result)
    })
})

app.get('/employees', (req, res) => {
    collection.find({}).toArray((err, result) => {
        if (err) return res.status(500).send(err)
        console.log(result)
        res.send(result)
    })
})

app.get('/employees/id/:uid', (req, res) => {
    console.log(req.params.uid)
    collection.findOne({"_id": new ObjectID(req.params.uid)}, (err, result) => {
        if (err) return res.status(500).send(err)
        res.send(result)
    })
})

app.get('/employees/count', (req, res) => {
    collection.countDocuments({})
    .then((result) => {
        res.status(200).send('{"count":' + result.toString() + '}')
    })
    .catch((err) => {
        return res.status(500).send(err)  
    })
})
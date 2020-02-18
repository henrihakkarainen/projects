/*
const request = require('request')
const api = 'https://webapi19sa-1.course.tamk.cloud/v1/weather/latest'

const fetchData = () => {
    request(api, (error, response, body) => {
        if (error) throw error
        console.log(JSON.parse(body))
    })
}

setInterval(fetchData, 5000)
*/

const request = require('request')
const MongoClient = require('mongodb')
const mongoUrl = 'mongodb://db:27017/'
const api = 'https://webapi19sa-1.course.tamk.cloud/v1/weather/latest'

const fetchData = () => {
    request(api, (error, response, body) => {
        if (error) throw error
        MongoClient.connect(mongoUrl, { useNewUrlParser : true }, (err, db) => {
            if (err) throw err
            const dbo = db.db('mydb')
            const json = JSON.parse(body)
            dbo.collection('latest').insertMany(json, (insertErr, res) => {
                if (insertErr) throw insertErr
                console.log('inserted', res)
                db.close()
            })
        })
    })
}
// setInterval(fetchData, 5000)

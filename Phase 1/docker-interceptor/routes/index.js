var express = require('express');
var Docker = require('dockerode');
var cmd = require('node-cmd');
var fs = require('fs');

var router = express.Router();
router.use(function (req, res, next) {
    // Referred from Stackoverflow.
    // Website you wish to allow to connect
    res.setHeader('Access-Control-Allow-Origin', '*');

    // Request methods you wish to allow
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');

    // Request headers you wish to allow
    res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');

    // Set to true if you need the website to include cookies in the requests sent
    // to the API (e.g. in case you use sessions)
    res.setHeader('Access-Control-Allow-Credentials', true);

    // Pass to next layer of middleware
    next();
});
/* GET home page. */
router.post('/', function(req, res, next) {
  req_ob = req.body;
  py_code = req_ob["py_code"];
  fs.writeFileSync('./my_script.py', py_code);
  docker = new Docker();
  cmd.get(
    `
    docker build -t python-node-docker .
    `,
    function(err, data, stderr){
        if (!err) {
           console.log('info from docker build command :\n\n',data);
           //console.log('error msg:  ',stderr);
           cmd.get(
            `
              docker run python-node-docker
            `,
            function(err, data, stderr){
                if (!err) {
                   console.log('data from docker run command :\n\n',data);
                   res.send(data);
                   //console.log('error msg:  ',stderr);
                } else {
                   console.log('error', err);
                   console.log('error msg:  ',stderr);
                   res.send(stderr);
                }
        
            }
        );
        } else {
           console.log('error', err);
           console.log('error msg:  ',stderr);
        }

    }
);
});


module.exports = router;

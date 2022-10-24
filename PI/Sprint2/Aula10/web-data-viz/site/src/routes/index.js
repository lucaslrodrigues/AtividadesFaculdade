<<<<<<< HEAD
var express = require("express");
var router = express.Router();

router.get("/", function (req, res) {
    res.render("index", { title: "Express" });
});

=======
var express = require("express");
var router = express.Router();

router.get("/", function (req, res) {
    res.render("index", { title: "Express" });
});

>>>>>>> ffbb1f02fd656456c61eea07acfa9dcbfce53425
module.exports = router;
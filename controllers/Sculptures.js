var Sculptures = require('../models/Sculptures');
// List of all Sculpturess
exports.Sculptures_list = function (req, res) {
    res.send('NOT IMPLEMENTED: Sculptures list');
};
// for a specific Sculptures.
exports.Sculptures_detail = function (req, res) {
    res.send('NOT IMPLEMENTED: Sculptures detail: ' + req.params.id);
};
// Handle Sculptures create on POST.
exports.Sculptures_create_post = function (req, res) {
    res.send('NOT IMPLEMENTED: Sculptures create POST');
};
// Handle Sculptures delete from on DELETE.
exports.Sculptures_delete = function (req, res) {
    res.send('NOT IMPLEMENTED: Sculptures delete DELETE ' + req.params.id);
};
// Handle Sculptures update form on PUT.
exports.Sculptures_update_put = function (req, res) {
    res.send('NOT IMPLEMENTED: Sculptures update PUT' + req.params.id);
};

// List of all Sculptures
exports.Sculpture_list = async function (req, res) {
    try {
        theSculptures = await Sculpture.find();
        res.send(theSculptures);
    }
    catch (err) {
        res.status(500);
        res.send(`{"error": ${err}}`);
    }
};

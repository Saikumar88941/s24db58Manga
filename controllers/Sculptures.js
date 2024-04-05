 
var Sculptures = require('../models/Sculptures');
// List of all Sculptures
exports.Sculptures_list = function(req, res) {
 res.send('NOT IMPLEMENTED: Sculptures list');
};
// for a specific Sculptures.
exports.Sculptures_detail = function(req, res) {
 res.send('NOT IMPLEMENTED: Sculptures detail: ' + req.params.id);
};
// Handle Sculptures create on POST.
exports.Sculptures_create_post = function(req, res) {
 res.send('NOT IMPLEMENTED: Sculptures create POST');
};
// Handle Sculptures delete from on DELETE.
exports.Sculptures_delete = function(req, res) {
 res.send('NOT IMPLEMENTED: Sculptures delete DELETE ' + req.params.id);
};
 
// Handle Sculptures update form on PUT.
exports.Sculptures_update_put = function(req, res) {
    res.send('NOT IMPLEMENTED: Sculptures update PUT' + req.params.id);
   };
 
 
exports.Sculptures_list = async function(req, res) {
    try{
    theSculptures = await Sculptures.find();
    res.send(theSculptures);
    }
    catch(err){
    res.status(500);
    res.send(`{"error": ${err}}`);
    }
   };
 
 
exports.Sculptures_view_all_Page = async function(req, res) {
    try{
    theSculpturess = await Sculptures.find();
    res.render('Sculptures', { title: 'Sculptures Search Results', results: theSculpturess });
    }
    catch(err){
    res.status(500);
    res.send(`{"error": ${err}}`);
    }
    };
 
 
// Handle Sculptures create on POST.
exports.Sculptures_create_post = async function(req, res) {
    console.log(req.body)
    let document = new Sculptures();
    // We are looking for a body, since POST does not have query parameters.
    // Even though bodies can be in many different formats, we will be picky
    // and require that it be a json object
    // {"Sculptures_type":"goat", "cost":12, "size":"large"}
    document.Sculptures_style = req.body.Sculptures_style;
    document.Sculptures_material = req.body.Sculptures_material;
    document.Sculptures_height = req.body.Sculptures_height;
    try{
    let result = await document.save();
    res.send(result);
    }
    catch(err){
    res.status(500);
    res.send(`{"error": ${err}}`);
    }
    };
   
   // Handle Sculptures create on POST.
exports.Sculptures_create_post = async function(req, res) {
    console.log(req.body)
    let document = new Sculptures();
    // We are looking for a body, since POST does not have query parameters.
    // Even though bodies can be in many different formats, we will be picky
    // and require that it be a json object
    // {"Sculptures_type":"goat", "cost":12, "size":"large"}
    document.Sculptures_style = req.body.Sculptures_style;
    document.Sculptures_material = req.body.Sculptures_author;
    document.Sculptures_height = req.body.Sculptures_height;
    try{
    let result = await document.save();
    res.send(result);
    }
    catch(err){
    res.status(500);
    res.send(`{"error": ${err}}`);
    }
    };
   
 // for a specific Sculptures.
// exports.Sculptures_detail = async function(req, res) {
//     console.log("detail" + req.params.id)
//     try {
//     result = await Sculptures.findById( req.params.id)
//     res.send(result)
//     } catch (error) {
//     res.status(500)
//     res.send(`{"error": document for id ${req.params.id} not found`);
//     }
//     };
exports.Sculptures_update_put = async function(req, res) {
    console.log(`update on id ${req.params.id} with body
    ${JSON.stringify(req.body)}`)
    try {
    let toUpdate = await Sculptures.findById( req.params.id)
    // Do updates of properties
    if(req.body.Sculptures_type)
    toUpdate.Sculptures_type = req.body.Sculptures_type;
    if(req.body.cost) toUpdate.cost = req.body.cost;
    if(req.body.size) toUpdate.size = req.body.size;
    let result = await toUpdate.save();
    console.log("Sucess " + result)
    res.send(result)
    } catch (err) {
    res.status(500)
    res.send(`{"error": ${err}: Update for id ${req.params.id}
    failed`);
    }
    };
const mongoose = require("mongoose")
const SculpturesSchema = mongoose.Schema({
    style: String,
    material : String,
    height: Number
})
module.exports = mongoose.model("Sculptures",
SculpturesSchema)
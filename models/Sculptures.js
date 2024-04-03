const mongoose = require("mongoose")
const SculpturesSchema = mongoose.Schema({
   Sculptures_style: String,
   Sculptures_material : String,
   Sculptures_height: Number
})
module.exports = mongoose.model("Sculptures",
SculpturesSchema)
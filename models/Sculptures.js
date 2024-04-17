const mongoose = require("mongoose")
const SculpturesSchema = mongoose.Schema({
   Sculptures_style: {
      type: String,
      minlength: 1,
      maxlength: 17,
   },
   Sculptures_material: String,
   Sculptures_height: Number
})
module.exports = mongoose.model("Sculptures",
   SculpturesSchema)
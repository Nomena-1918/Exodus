using Microsoft.AspNetCore.Mvc;

namespace Controllers
{
    [ApiController]
    [Route("[controller]")]

    public class PetitController : ControllerBase
    {

        [HttpGet(Name = "Petits")]
        public IEnumerable<Petit> Get()
        {
            return null;
        }

        [HttpPost(Name = "Petits")]
        public void Post()
        {

        }

        [HttpPut(Name = "Petits")]
        public void Put(string id)
        {
        
        }

        [HttpDelete(Name = "Petits")]
        public void Delete(string id)
        {
        
        }

    }

}

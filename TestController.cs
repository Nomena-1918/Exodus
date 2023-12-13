using Microsoft.AspNetCore.Mvc;

namespace Controllers
{
    [ApiController]
    [Route("[controller]")]

    public class TESTController : ControllerBase
    {

        [HttpGet(Name = "TESTs")]
        public IEnumerable<TEST> Get()
        {
            return null;
        }

        [HttpPost(Name = "TESTs")]
        public void Post()
        {

        }

        [HttpPut(Name = "TESTs")]
        public void Put(string id)
        {
        
        }

        [HttpDelete(Name = "TESTs")]
        public void Delete(string id)
        {
        
        }

    }

}

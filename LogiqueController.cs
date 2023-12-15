using Microsoft.AspNetCore.Mvc;

namespace Controllers
{
    [ApiController]
    [Route("[controller]")]

    public class LogiqueController : ControllerBase
    {

        [HttpGet(Name = "Logiques")]
        public IEnumerable<Logique> Get()
        {
            return null;
        }

        [HttpPost(Name = "Logiques")]
        public void Post()
        {

        }

        [HttpPut(Name = "Logiques")]
        public void Put(string id)
        {
        
        }

        [HttpDelete(Name = "Logiques")]
        public void Delete(string id)
        {
        
        }

    }

}

using Microsoft.AspNetCore.Mvc;

namespace Controllers
{
    [ApiController]
    [Route("[controller]")]

    public class 3Controller : ControllerBase
    {

        [HttpGet(Name = "3s")]
        public IEnumerable<3> Get()
        {
            return null;
        }

        [HttpPost(Name = "3s")]
        public void Post()
        {

        }

        [HttpPut(Name = "3s")]
        public void Put(string id)
        {
        
        }

        [HttpDelete(Name = "3s")]
        public void Delete(string id)
        {
        
        }

    }

}

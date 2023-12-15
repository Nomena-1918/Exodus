using Microsoft.AspNetCore.Mvc;

namespace Controllers
{
    [ApiController]
    [Route("[controller]")]

    public class YouController : ControllerBase
    {

        [HttpGet(Name = "Yous")]
        public IEnumerable<You> Get()
        {
            return null;
        }

        [HttpPost(Name = "Yous")]
        public void Post()
        {

        }

        [HttpPut(Name = "Yous")]
        public void Put(string id)
        {
        
        }

        [HttpDelete(Name = "Yous")]
        public void Delete(string id)
        {
        
        }

    }

}

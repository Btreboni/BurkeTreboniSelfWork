using BabySitterKata.Services.Interfaces;
using Microsoft.AspNetCore.Cors;
using Microsoft.AspNetCore.Mvc;

namespace BabySitterKata.Controllers
{
    [Produces("application/json")]
    [Route("api/calculate")]
    [EnableCors("AllowAllHeaders")]
    public class CalculatorController : Controller
    {
        private readonly ICalculatorService _calculatorService;

        public CalculatorController(ICalculatorService calculatorService)
        {
            _calculatorService = calculatorService;
        }

        // POST api/calculate/wages
        [HttpPost("wages")]
        [ProducesResponseType(typeof(string), statusCode: 201)]
        public IActionResult Post([FromBody]Models.HourlyDataDto data)
        {
            var test = _calculatorService.CalculateNightlyWage(data);
            return Ok(test);
        }
    }
}

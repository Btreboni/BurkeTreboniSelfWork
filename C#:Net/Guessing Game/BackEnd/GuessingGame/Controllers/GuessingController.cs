using GuessingGame.Models;
using GuessingGame.Services.Interfaces;
using Microsoft.AspNetCore.Mvc;

namespace GuessingGame.Controllers
{
    [Produces("application/json")]
    [Route("api/guess")]
    public class GuessingController : Controller
    {

        private readonly IGuessingService _service;

        public GuessingController(IGuessingService service)
        {
            _service = service;
        }

        //GET api/guess
        [HttpGet]         [ProducesResponseType(typeof(GuessDto), statusCode: 200)]         public IActionResult Get()         {
            var numberToGuess = _service.ProcessGuess();

            return Ok(numberToGuess);         }
    }
}

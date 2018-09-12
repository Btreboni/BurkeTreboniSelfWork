using System;
using Newtonsoft.Json;

namespace GuessingGame.Models
{
    public class GuessDto
    {
        [JsonProperty("guess")]
        public int Guess { get; set; }
    }
}

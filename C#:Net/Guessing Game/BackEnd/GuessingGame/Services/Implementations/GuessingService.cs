using System;
using GuessingGame.Models;
using GuessingGame.Services.Interfaces;

namespace GuessingGame.Services.Implementations
{
    public class GuessingService : IGuessingService
    {
        public GuessDto ProcessGuess()
        {
            Random random = new Random();
            int randomNum = random.Next(1, 100);

            GuessDto number = new GuessDto
            {
                Guess = randomNum
            };

            return number;
        }
    }
}

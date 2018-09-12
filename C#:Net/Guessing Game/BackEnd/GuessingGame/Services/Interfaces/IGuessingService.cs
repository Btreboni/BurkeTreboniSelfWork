using System;
using GuessingGame.Models;

namespace GuessingGame.Services.Interfaces
{
    public interface IGuessingService
    {
        GuessDto ProcessGuess();
    }
}

using System;
using BabySitterKata.Models;

namespace BabySitterKata.Services.Interfaces
{
    public interface ICalculatorService
    {
        string CalculateNightlyWage(HourlyDataDto data);
    }
}

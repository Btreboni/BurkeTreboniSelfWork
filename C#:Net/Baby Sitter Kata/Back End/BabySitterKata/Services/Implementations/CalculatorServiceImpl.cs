using System;
using BabySitterKata.Models;
using BabySitterKata.Services.Interfaces;

namespace BabySitterKata.Services.Implementations
{
    public class CalculatorServiceImpl : ICalculatorService
    {
        private double startToDowntimeRate = 12;
        private double downtimeToMidnightRate = 8;
        private double afterMidnightRate = 16;

        /// <summary>
        /// Calculates the babysitters wage, using the start time, the time the children
        /// are put down, and the time the babysitter leaves;
        /// </summary>
        /// <returns>The nightly wage.</returns>
        /// <param name="data">Data.</param>
        public string CalculateNightlyWage(HourlyDataDto data)
        {
            var wage = 0.0;
            var wageToReturn = "";

            //start time to down time wage, checking to see if downtime was after midnight
            if(data.DownTime > 12){
                wage = CalculateStartToDownTimeIfDownTimeIsAfterMidnight(data.EndTime, data.StartTime);
                wageToReturn = ConvertWageToDisplay(wage);

                return wageToReturn;
            } else{
                var startToDownTimeWage = CalculateStartToDownTimeWage(data.DownTime, data.StartTime);

                //down time to midnight wage, checking to see if downtime was after midnight
                var downTimeToMidnightWage = CalculateDownTimeToMidnightWage(data.DownTime);

                //after midnight wage
                var afterMidnightWage = CalculateAfterMidnightWage(data.EndTime);

                //add up wages
                wage = CalculateWages(startToDownTimeWage, downTimeToMidnightWage, afterMidnightWage);

                //Convert to display
                wageToReturn = ConvertWageToDisplay(wage);

                return wageToReturn;
            }
        }

        /// <summary>
        /// Calculates the wages to return from the start time to the end time when the end time
        /// occurs before midnight
        /// </summary>
        /// <returns>The start to down time wage.</returns>
        /// <param name="downTime">Down time.</param>
        /// <param name="startTime">Start time.</param>
        public double CalculateStartToDownTimeWage(double downTime, double startTime){
            var wage = (downTime - startTime) * startToDowntimeRate;
            return wage;
        }

        /// <summary>
        /// Calculates the wages to return from start time to the end time when the end time
        /// occurs after midnight, since the wage is higher
        /// </summary>
        /// <returns>The start to down time if down time is after midnight.</returns>
        /// <param name="downTime">Down time.</param>
        /// <param name="startTime">Start time.</param>
        public double CalculateStartToDownTimeIfDownTimeIsAfterMidnight(double endTime, double startTime){
            var startTimeToMidnight = (12 - startTime) * startToDowntimeRate;
            var afterMidnight = CalculateAfterMidnightWage(endTime);
            var wage = startTimeToMidnight + afterMidnight;
            return wage;
        }

        /// <summary>
        /// If the downTime is after midnight, we've already accounted for it in the startToDownTimeWage, 
        /// so return 0. If not we will calculate the midnight rate
        /// </summary>
        /// <returns>The down time to midnight wage.</returns>
        /// <param name="downTime">Down time.</param>
        public double CalculateDownTimeToMidnightWage(double downTime){
            var wage = downTime > 12 ? 0 : (12 - downTime) * downtimeToMidnightRate;
            return wage;
        }

        /// <summary>
        /// Calculates the wages after midnight
        /// </summary>
        /// <returns>The after midnight wage.</returns>
        /// <param name="endTime">End time.</param>
        public double CalculateAfterMidnightWage(double endTime){
            var wage = endTime < 12 ? 0 : (endTime - 12) * afterMidnightRate;
            return wage;
        }

        /// <summary>
        /// Converts the double into a decimal for display purposes.
        /// </summary>
        /// <returns>The wage to decimal.</returns>
        /// <param name="wage">Wage.</param>
        public string ConvertWageToDisplay(double wage){
            var displayWageToReturn = $"${wage}";
            return displayWageToReturn;
        }

        /// <summary>
        /// Adds up all of the wages
        /// </summary>
        /// <returns>The wages.</returns>
        /// <param name="startToDownTimeWage">Start to down time wage.</param>
        /// <param name="downTimeToMidnightWage">Down time to midnight wage.</param>
        /// <param name="afterMidnightWage">After midnight wage.</param>
        public double CalculateWages(double startToDownTimeWage, double downTimeToMidnightWage,
            double afterMidnightWage){
            var wage = startToDownTimeWage + downTimeToMidnightWage + afterMidnightWage;
            return wage;
        }
    }
}

using System;
using Newtonsoft.Json;

namespace BabySitterKata.Models
{
    public class HourlyDataDto
    {
        [JsonProperty("startTime")]
        public double StartTime { get; set; }

        [JsonProperty("downTime")]
        public double DownTime { get; set; }

        [JsonProperty("endTime")]
        public double EndTime { get; set; }
    }
}

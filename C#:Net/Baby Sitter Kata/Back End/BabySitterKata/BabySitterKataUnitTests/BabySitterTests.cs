using BabySitterKata.Services.Implementations;
using Foundation;

namespace BabySitterKataUnitTests
{
    [TestFixture]
    public class BabySitterTests
    {
        private readonly CalculatorServiceImpl _calculatorService;

        public BabySitterTests(CalculatorServiceImpl calculatorService){
            _calculatorService = calculatorService;
        }

        [Test]
        public void TestCalculateStartToDownTimeWage(){
            var downTime = 8;
            var startTime = 5;

            var wage = _calculatorService.CalculateStartToDownTimeWage(downTime, startTime);
            Assert.AreEqual(36, wage);
        }
    }
}

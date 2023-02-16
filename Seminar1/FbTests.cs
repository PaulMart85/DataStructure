using BenchmarkDotNet.Attributes;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lesson1_2
{

    [MemoryDiagnoser]
    public class FbTests
    {

        [Benchmark]
        public void fb1Test()
        {
            fb1(35);
        }

        [Benchmark]
        public void fb2Test()
        {
            fb2(35);
        }

        private long fb1(int num)
        {
            if (num == 0 || num == 1) return num;
            return fb1(num - 1) + fb1(num - 2);
        }

        private long fb2(int num)
        {
            if (num == 0 || num == 1) return num;

            long[] numbers = new long[num + 1];
            numbers[0] = 0;
            numbers[1] = 1;
            for (int i = 2; i <= num; i++)
            {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
            return numbers[num]; //numbers.length -1
        }
    }
}

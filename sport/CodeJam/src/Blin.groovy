def caseNumber = 0;

def fileName = '..\\B-small-practice.in';
def input = new FileInputStream(fileName)
def reader = new BufferedReader(new InputStreamReader(input))

reader.readLine().toInteger();

reader.eachLine {
   it += '+'
   def flipCount = 0;

   for (int i = 0; i < it.size() - 1; i++)
      if (it[i] != it[i + 1]) n++;

   println "Case #" + ++caseNumber + ": " + n
}


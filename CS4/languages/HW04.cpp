/*
	Complete the following functions and submit your file to Canvas.

	========= IMPORTANT ==========
	Change the name of the file so that it contains your student ID or name.
	Do not change the names of the functions. The system will specifically look for the names used in this file. Changing the name of a function will automatically make you lose the points for that function.
	Do not change the number of arguments in the functions. Changing the number of arguments of a function will automatically make you lose the points for that function.
	Make sure that nothing additional is printed as the result of running this file. Avoid printing names, student IDs, or any other messages. If you print anything else, the system will wrongly grade your solutions.
	If your file does not compile, your grade will be zero. Then, submit only code that works.

	To compile, run: "g++ HW05.cpp -std=c++11 -o HW05"
*/

#include <iostream>
#include <vector>

using namespace std;

int sum(vector<int> v)
{
	if(v.empty())
		return 0;
	else{
		int i = v.back();
		v.pop_back();
		return i+sum(v);
	}
}


int fibonacci(int n)
{
	if (n<=0)
		return 0;
	else if (n==1){
		return 1;
	}
	else
		return fibonacci(n-2)+fibonacci(n-1);
}

int toBinary(int n)
{ 
	if (n == 0)
      return  0;
   else
      return  n % 2 + 10 * toBinary(n / 2)	;

}

int main()
{
	// vector<int> g1; 
  
    // for (int i = 1; i <= 4; i++) 
    //     g1.push_back(i); 
	
	// cout << sum(g1);

	// cout << fibonacci(3);

	cout << toBinary(4);
	
}

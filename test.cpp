#include <iostream>
#include <string>

int main ()
{
  std::string str ("Test string length calculations");
  std::cout << "The size of str is " << str.len() << " bytes.\n";
  return 0;
}

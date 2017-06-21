#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main(){

	string str;
	int len(0);

	cout << "Enter the string to test for palindrome - ";

	cin >> str;

	len = str.size();
	
	string temp =str;
	reverse(temp.begin(), temp.end());

	if(str.compare(temp) != 0)
		cout << endl << str << " is not a palindrome\n";
	else
		cout << endl << str << " is a palindrome\n";


	/*for(int i(0); i<len/2; i++)
		if(str[i] != str[len-i-1]){
			cout << endl << str << " is not a palindrome\n";

			return 0;
		}
	cout << endl << str << " is a palindrome\n";*/

	return 0;
}

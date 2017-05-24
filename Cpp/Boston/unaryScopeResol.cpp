#include<iostream>

using namespace std;

int var = 66;

int main(){

	int var = 20;

	cout << "Local Variable referred like 'var' - " << var<<endl;
	cout << "Global Variable referred like '::var' - " << ::var<<endl;
}

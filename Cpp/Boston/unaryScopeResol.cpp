#include<iostream>

using namespace std;

class MyClass{
    public:
    static int a;
};

int MyClass::a = 1;

int var = 66;

int main(){

	int var = 20;

	cout << "Local Variable referred like 'var' - " << var<<endl;
	cout << "Global Variable referred like '::var' - " << ::var<<endl;
    cout << "Static Class Member 'MyClass::a' - " << MyClass::a<<endl;
}

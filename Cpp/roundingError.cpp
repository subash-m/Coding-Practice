#include<iostream>
#include<iomanip>

int main(){

	// 1/10  =  0.1 in decimal
	// 0.000110011001100.. in binary
	// because of which we will run into precision problems.
	double d1(0.1);
	double d2(0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1+0.1);
	std::cout << d1 << std::endl;
	std::cout << std::setprecision(17);
	std::cout << d1 << std::endl;
	
	std::cout << "This is because the double had to truncate the \n\
approximation due to its limited memory, which resulted in a number \n\
that is not exactly 0.1. This is called rounding error, which grows on \n\
multiplication and division\n\n\n";

	std::cout << d2 << std::endl;
	std::cout << "Even though 0.1 has a rounding error in the 17th\n\
significant digit, when we add 0.1 ten times, the rounding error has\n\
crept into the 16th significant digit.\n";
	return 0;
}

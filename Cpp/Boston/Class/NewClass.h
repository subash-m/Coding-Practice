#ifndef NEW_CLASS_H
#define NEW_CLASS_H

class NewClass{

	public:
		NewClass(int, int);
		~NewClass();
		void print();
		void constFnPrint() const;
		NewClass operator+(NewClass);
		int getRegVar();
	private:
		int regVar;
		//int const constVar;
};
#endif

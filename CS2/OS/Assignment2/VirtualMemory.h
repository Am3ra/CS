enum accesTypes
{
    READ = 'R',
    WRITE = 'W',
    DIRTY,
    VALID,
    INVALID,
    EMPTY
};

struct MMUstruct
{
    int address,
        dirty_bit,
        valid,
        last_use;
};

struct reference
{
    unsigned int address;
    int access;
};
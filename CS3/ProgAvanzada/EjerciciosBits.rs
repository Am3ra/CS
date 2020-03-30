fn main(){
    let num = 0x59u8;
    let mask = 8u8;
    println!("NUMERO INICIAL: {:#08b}", num);
    println!("estado de 3er bit: {}", num&mask!=0);
    println!("Apagar 3er bit : {:#08b}", num&(!mask));
    println!("prender 3er bit : {:#08b}", num|mask);
    println!("Invierte 3er bit : {:#08b}", num^mask);

}
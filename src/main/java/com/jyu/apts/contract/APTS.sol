pragma solidity >0.4.0 <0.6.0;

contract APTS {

  mapping (string => string) record;

  function setRecord(string code, string addr) public {
    record[code] = addr;
  }

  function getRecord(string code) public view returns(string) {
    return record[code];
  }
}

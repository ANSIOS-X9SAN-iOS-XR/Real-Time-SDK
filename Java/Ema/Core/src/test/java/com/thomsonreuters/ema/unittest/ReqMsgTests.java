///*|-----------------------------------------------------------------------------
// *|            This source code is provided under the Apache 2.0 license      --
// *|  and is provided AS IS with no warranty or guarantee of fit for purpose.  --
// *|                See the project's LICENSE.md for details.                  --
// *|           Copyright (C) 2019 Refinitiv. All rights reserved.            --
///*|-----------------------------------------------------------------------------

package com.thomsonreuters.ema.unittest;

import java.nio.ByteBuffer;
import java.util.Iterator;

import com.thomsonreuters.ema.access.*;
import com.thomsonreuters.ema.access.FieldEntry;
import com.thomsonreuters.ema.rdm.EmaRdm;
import com.thomsonreuters.ema.unittest.TestUtilities.EncodingTypeFlags;
import com.thomsonreuters.upa.codec.*;

import junit.framework.TestCase;

public class ReqMsgTests extends TestCase 
{
	public ReqMsgTests(String name)
	{
		super(name);
	}
	
	public void testReqMsg_EncodeDecode()
	{
		TestUtilities.printTestHead("testRequestMsg_EncodeDecode", "ema encoding ema decoding");

	    com.thomsonreuters.ema.access.FieldList fl = EmaFactory.createFieldList();
	    
	    TestUtilities.EmaEncodeFieldListAll(fl);
	    
	    com.thomsonreuters.ema.access.ReqMsg reqMsg = EmaFactory.createReqMsg();
	    
		System.out.println("Begin EMA ReqMsg test after constructor");

		TestUtilities.checkResult(reqMsg.domainType() == com.thomsonreuters.ema.rdm.EmaRdm.MMT_MARKET_PRICE, "ReqMsg.domainType()");
		
		TestUtilities.checkResult(reqMsg.streamId() == 0, "ReqMsg.streamId()");
		
		TestUtilities.checkResult(!reqMsg.hasQos(), "ReqMsg.hasQos()");
		
		TestUtilities.checkResult(reqMsg.hasMsgKey(), "ReqMsg.hasMsgKey()");

		TestUtilities.checkResult(!reqMsg.hasId(), "ReqMsg.hasId()");
		
		TestUtilities.checkResult(!reqMsg.hasFilter(), "ReqMsg.hasFilter()");
		
		TestUtilities.checkResult(!reqMsg.hasServiceId(), "ReqMsg.hasServiceId()");
		
		TestUtilities.checkResult(!reqMsg.hasServiceName(), "ReqMsg.hasServiceName()");
		
		TestUtilities.checkResult(!reqMsg.hasNameType(), "ReqMsg.hasNameType()");
		
		TestUtilities.checkResult(!reqMsg.hasName(), "ReqMsg.hasName()");
		
		TestUtilities.checkResult(!reqMsg.hasPriority(), "ReqMsg.hasPriority()");
		
		TestUtilities.checkResult(!reqMsg.hasQos(), "ReqMsg.hasQos()");
		
		TestUtilities.checkResult(reqMsg.attrib().dataType() == com.thomsonreuters.ema.access.DataType.DataTypes.NO_DATA, "ReqMsg.attrib().dataType()");
		
		TestUtilities.checkResult(reqMsg.payload().dataType() == com.thomsonreuters.ema.access.DataType.DataTypes.NO_DATA, "ReqMsg.payload().dataType()");

		System.out.println("End EMA ReqMsg test after constructor");
		System.out.println();		
		
	    System.out.println("Begin EMA ReqMsg Set");
	    
	    reqMsg.domainType( com.thomsonreuters.ema.rdm.EmaRdm.MMT_MARKET_PRICE );
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
	    
	    reqMsg.initialImage(true);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
	    
	    reqMsg.interestAfterRefresh(true);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
		
	    reqMsg.streamId( 15 );
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
		
	    reqMsg.qos(OmmQos.Timeliness.REALTIME, OmmQos.Rate.TICK_BY_TICK);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    

	    reqMsg.name("ABCDEF");
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
		
	    reqMsg.nameType( com.thomsonreuters.upa.rdm.InstrumentNameTypes.RIC );
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    

	    reqMsg.serviceId(5);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    

	    reqMsg.filter( 12 );
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
	
	    reqMsg.id(21);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
	    
	    reqMsg.priority(5, 7);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
	    
	    reqMsg.qos(com.thomsonreuters.ema.access.ReqMsg.Timeliness.REALTIME, com.thomsonreuters.ema.access.ReqMsg.Rate.TICK_BY_TICK);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
	    
	    reqMsg.conflatedInUpdates(true);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
		
	    reqMsg.attrib(fl);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    
		
	    reqMsg.payload(fl);
		TestUtilities.checkResult("ReqMsg.toString() == toString() not supported", reqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n"));	    

		System.out.println("End EMA ReqMsg Set");
		System.out.println();

		System.out.println("Begin EMA ReqMsg Decoding");

		com.thomsonreuters.ema.access.ReqMsg emaReqMsg = JUnitTestConnect.createReqMsg();

		JUnitTestConnect.setRsslData(emaReqMsg, reqMsg, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);

		// check that we can still get the toString on encoded/decoded msg.
		TestUtilities.checkResult("ReqMsg.toString() != toString() not supported", !(emaReqMsg.toString().equals("\nDecoding of just encoded object in the same application is not supported\n")));	 		
	
		TestUtilities.checkResult(emaReqMsg.domainType() == com.thomsonreuters.ema.rdm.EmaRdm.MMT_MARKET_PRICE, "ReqMsg.domainType()");
		
		TestUtilities.checkResult(emaReqMsg.initialImage() == true, "ReqMsg.initialImage()");
		
		TestUtilities.checkResult(emaReqMsg.interestAfterRefresh() == true, "ReqMsg.interestAfterRefresh()");
		
		TestUtilities.checkResult(emaReqMsg.streamId() == 15, "ReqMsg.streamId()");

		TestUtilities.checkResult(emaReqMsg.hasQos(), "ReqMsg.hasQos()");
	
		TestUtilities.checkResult(emaReqMsg.hasMsgKey(), "ReqMsg.hasMsgKey()");

		TestUtilities.checkResult(emaReqMsg.hasId(), "ReqMsg.hasId()");
		
		TestUtilities.checkResult(emaReqMsg.id() == 21, "ReqMsg.id()");

		TestUtilities.checkResult(emaReqMsg.hasFilter(), "ReqMsg.hasFilter()");
		
		TestUtilities.checkResult(emaReqMsg.filter() == 12 , "ReqMsg.hasFilter()");

		TestUtilities.checkResult(!emaReqMsg.hasServiceName(), "ReqMsg.hasServiceName()");
		
		TestUtilities.checkResult(emaReqMsg.serviceId() == 5 , "ReqMsg.serviceId()");

		TestUtilities.checkResult(emaReqMsg.hasNameType(), "ReqMsg.hasNameType()");
		
		TestUtilities.checkResult(emaReqMsg.nameType() == com.thomsonreuters.ema.rdm.EmaRdm.INSTRUMENT_NAME_RIC , "ReqMsg.nameType()");

		TestUtilities.checkResult(emaReqMsg.hasName(), "ReqMsg.hasName()");
		
		TestUtilities.checkResult(emaReqMsg.name().compareTo("ABCDEF") == 0, "ReqMsg.name()");
		
		TestUtilities.checkResult(reqMsg.hasPriority(), "ReqMsg.hasPriority()");
		
		TestUtilities.checkResult(emaReqMsg.priorityClass() == 5, "ReqMsg.priorityClass()");
		
		TestUtilities.checkResult(emaReqMsg.priorityCount() == 7, "ReqMsg.priorityCount()");
		
		TestUtilities.checkResult(reqMsg.hasQos(), "ReqMsg.hasQos()");
		
		TestUtilities.checkResult(reqMsg.qosRate() ==  com.thomsonreuters.ema.access.ReqMsg.Rate.TICK_BY_TICK, "ReqMsg.qosRate()");
		
		TestUtilities.checkResult(reqMsg.qosTimeliness() ==  com.thomsonreuters.ema.access.ReqMsg.Timeliness.REALTIME, "ReqMsg.qosTimeliness()");
		
		TestUtilities.checkResult(reqMsg.conflatedInUpdates() ==  true, "ReqMsg.conflatedInUpdates()");

		TestUtilities.checkResult(emaReqMsg.attrib().dataType() == com.thomsonreuters.ema.access.DataType.DataTypes.FIELD_LIST, "ReqMsg.attrib().dataType()");
		
		TestUtilities.checkResult(emaReqMsg.payload().dataType() == com.thomsonreuters.ema.access.DataType.DataTypes.FIELD_LIST, "ReqMsg.payload().dataType()");

		System.out.println("End EMA ReqMsg Decoding");
		System.out.println();

		reqMsg.clear();
		
		System.out.println("Begin EMA ReqMsg test after clear");

		TestUtilities.checkResult(reqMsg.domainType() == com.thomsonreuters.ema.rdm.EmaRdm.MMT_MARKET_PRICE, "ReqMsg.domainType()");
		
		TestUtilities.checkResult(reqMsg.streamId() == 0, "ReqMsg.streamId()");
		
		TestUtilities.checkResult(!reqMsg.hasQos(), "ReqMsg.hasQos()");
		
		TestUtilities.checkResult(reqMsg.hasMsgKey(), "ReqMsg.hasMsgKey()");

		TestUtilities.checkResult(!reqMsg.hasId(), "ReqMsg.hasId()");
		
		TestUtilities.checkResult(!reqMsg.hasFilter(), "ReqMsg.hasFilter()");
		
		TestUtilities.checkResult(!reqMsg.hasServiceId(), "ReqMsg.hasServiceId()");
		
		TestUtilities.checkResult(!reqMsg.hasServiceName(), "ReqMsg.hasServiceName()");
		
		TestUtilities.checkResult(!reqMsg.hasNameType(), "ReqMsg.hasNameType()");
		
		TestUtilities.checkResult(!reqMsg.hasName(), "ReqMsg.hasName()");
		
		TestUtilities.checkResult(!reqMsg.hasQos(), "ReqMsg.hasQos()");
		
		TestUtilities.checkResult(reqMsg.attrib().dataType() == com.thomsonreuters.ema.access.DataType.DataTypes.NO_DATA, "ReqMsg.attrib().dataType()");
		
		TestUtilities.checkResult(reqMsg.payload().dataType() == com.thomsonreuters.ema.access.DataType.DataTypes.NO_DATA, "ReqMsg.payload().dataType()");

		System.out.println("End EMA ReqMsg test after clear");
		System.out.println();
	}
	
	public void testReqMsg_EncodeUPARequestMsgWithFieldListTypeAsAttrib_ExtendedHeader_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode()
	{ 
	    int retVal;
		 
		TestUtilities.printTestHead("testReqMsg_EncodeUPARequestMsgWithFieldListTypeAsAttrib_ExtendedHeader_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode", "Encode ReqMsg with UPA for FieldList as attrib, extended header and payload, Encode it to another ReqMsg.");

        // Create a UPA Buffer to encode into
        com.thomsonreuters.upa.codec.Buffer buffer = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
        buffer.data(ByteBuffer.allocate(8192));
        
    	int majorVersion = Codec.majorVersion();  // This should be initialized to the MAJOR version of RWF being encoded
		int minorVersion = Codec.minorVersion();  // This should be initialized to the MINOR version of RWF being encoded
	
		// Create and clear iterator to prepare for encoding
		com.thomsonreuters.upa.codec.EncodeIterator encodeIter = CodecFactory.createEncodeIterator();
		encodeIter.clear();
	
		// Associate buffer and iterator and set proper protocol version information on iterator.
		if ((retVal = encodeIter.setBufferAndRWFVersion(buffer, majorVersion, minorVersion)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with setBufferAndRWFVersion. "
							+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		if ( ( retVal = TestUtilities.upa_EncodeRequestMsgAll(encodeIter, com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with TestUtilities.upa_EncodeRequestMsgAll(). "
					+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		 // Decode ReqMsg with EMA.
	     com.thomsonreuters.ema.access.ReqMsg reqMsg = JUnitTestConnect.createReqMsg();
	     JUnitTestConnect.setRsslData(reqMsg, buffer, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	     TestUtilities.EmaDecode_UPARequestMsgAll(reqMsg, com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST);
	
	     com.thomsonreuters.ema.access.ReqMsg copyReqMsg = EmaFactory.createReqMsg();
	     
	     // Encode to another ReqMsg
	     copyReqMsg.extendedHeader(reqMsg.extendedHeader());
	     copyReqMsg.attrib(reqMsg.attrib().data());
	     copyReqMsg.payload(reqMsg.payload().data());
	     
	     com.thomsonreuters.ema.access.ReqMsg decCopyReqMsg = JUnitTestConnect.createReqMsg();
	     
	     JUnitTestConnect.setRsslData(decCopyReqMsg, copyReqMsg, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	     // Check result
	     TestUtilities.checkResult(decCopyReqMsg.extendedHeader().equals(reqMsg.extendedHeader()));
	     TestUtilities.EmaDecode_UPAFieldListAll(decCopyReqMsg.attrib().fieldList(), TestUtilities.EncodingTypeFlags.PRIMITIVE_TYPES);
	     TestUtilities.EmaDecode_UPAFieldListAll(decCopyReqMsg.payload().fieldList(), TestUtilities.EncodingTypeFlags.PRIMITIVE_TYPES);
	     
	     System.out.println("\ttestReqMsg_EncodeUPARequestMsgWithFieldListTypeAsAttrib_ExtendedHeader_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode passed");
	}
	
	public void testReqMsg_EncodeUPAReqMsgWithElementListTypeAsAttrib_ExtendedHeader_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode()
	{ 
	    int retVal;
		 
		TestUtilities.printTestHead("testReqMsg_EncodeUPAReqMsgWithElementListTypeAsAttrib_ExtendedHeader_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode", "Encode ReqMsg with UPA for ElementList as attrib, extended header and payload, Encode it to another ReqMsg.");

        // Create a UPA Buffer to encode into
        com.thomsonreuters.upa.codec.Buffer buffer = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
        buffer.data(ByteBuffer.allocate(8192));
        
    	int majorVersion = Codec.majorVersion();  // This should be initialized to the MAJOR version of RWF being encoded
		int minorVersion = Codec.minorVersion();  // This should be initialized to the MINOR version of RWF being encoded
	
		// Create and clear iterator to prepare for encoding
		com.thomsonreuters.upa.codec.EncodeIterator encodeIter = CodecFactory.createEncodeIterator();
		encodeIter.clear();
	
		// Associate buffer and iterator and set proper protocol version information on iterator.
		if ((retVal = encodeIter.setBufferAndRWFVersion(buffer, majorVersion, minorVersion)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with setBufferAndRWFVersion. "
							+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		if ( ( retVal = TestUtilities.upa_EncodeRequestMsgAll(encodeIter, com.thomsonreuters.upa.codec.DataTypes.ELEMENT_LIST)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with TestUtilities.upa_EncodeRequestMsgAll(). "
					+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		 // Decode ReqMsg with EMA.
	     com.thomsonreuters.ema.access.ReqMsg reqMsg = JUnitTestConnect.createReqMsg();
	     JUnitTestConnect.setRsslData(reqMsg, buffer, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	     TestUtilities.EmaDecode_UPARequestMsgAll(reqMsg, com.thomsonreuters.upa.codec.DataTypes.ELEMENT_LIST);
	
	     com.thomsonreuters.ema.access.ReqMsg copyReqMsg = EmaFactory.createReqMsg();
	     
	     // Encode to another ReqMsg
	     copyReqMsg.extendedHeader(reqMsg.extendedHeader());
	     copyReqMsg.attrib(reqMsg.attrib().data());
	     copyReqMsg.payload(reqMsg.payload().data());
	     
	     com.thomsonreuters.ema.access.ReqMsg decCopyReqMsg = JUnitTestConnect.createReqMsg();
	     
	     JUnitTestConnect.setRsslData(decCopyReqMsg, copyReqMsg, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	     // Check result
	     TestUtilities.checkResult(decCopyReqMsg.extendedHeader().equals(reqMsg.extendedHeader()));
	     TestUtilities.EmaDecode_UPAElementListAll(decCopyReqMsg.attrib().elementList(), TestUtilities.EncodingTypeFlags.PRIMITIVE_TYPES);
	     TestUtilities.EmaDecode_UPAElementListAll(decCopyReqMsg.payload().elementList(), TestUtilities.EncodingTypeFlags.PRIMITIVE_TYPES);
	     
	     System.out.println("\ttestReqMsg_EncodeUPAReqMsgWithElementListTypeAsAttrib_ExtendedHeader_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode passed");
	}
	
	public void testReqMsg_EncodeUPAReqMsgWithFilterListTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode()
	{ 
	    int retVal;
		 
		TestUtilities.printTestHead("testReqMsg_EncodeUPAReqMsgWithFilterListTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode", "Encode ReqMsg with UPA for FilterList as attrib, payload, Encode it to another ReqMsg.");

        // Create a UPA Buffer to encode into
        com.thomsonreuters.upa.codec.Buffer buffer = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
        buffer.data(ByteBuffer.allocate(8192));
        
    	int majorVersion = Codec.majorVersion();  // This should be initialized to the MAJOR version of RWF being encoded
		int minorVersion = Codec.minorVersion();  // This should be initialized to the MINOR version of RWF being encoded
	
		// Create and clear iterator to prepare for encoding
		com.thomsonreuters.upa.codec.EncodeIterator encodeIter = CodecFactory.createEncodeIterator();
		encodeIter.clear();
	
		// Associate buffer and iterator and set proper protocol version information on iterator.
		if ((retVal = encodeIter.setBufferAndRWFVersion(buffer, majorVersion, minorVersion)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with setBufferAndRWFVersion. "
							+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		if ( ( retVal = TestUtilities.upa_EncodeRequestMsgAll(encodeIter, com.thomsonreuters.upa.codec.DataTypes.FILTER_LIST)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with TestUtilities.upa_EncodeRequestMsgAll(). "
					+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		 // Decode ReqMsg with EMA.
	     com.thomsonreuters.ema.access.ReqMsg reqMsg = JUnitTestConnect.createReqMsg();
	     JUnitTestConnect.setRsslData(reqMsg, buffer, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	    TestUtilities.EmaDecode_UPARequestMsgAll(reqMsg, com.thomsonreuters.upa.codec.DataTypes.FILTER_LIST);
	
	     com.thomsonreuters.ema.access.ReqMsg copyReqMsg = EmaFactory.createReqMsg();
	     
	     // Encode to another ReqMsg
	     copyReqMsg.extendedHeader(reqMsg.extendedHeader());
	     copyReqMsg.attrib(reqMsg.attrib().data());
	     copyReqMsg.payload(reqMsg.payload().data());
	     
	     com.thomsonreuters.ema.access.ReqMsg decCopyReqMsg = JUnitTestConnect.createReqMsg();
	     
	     JUnitTestConnect.setRsslData(decCopyReqMsg, copyReqMsg, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	     // Check result
	     TestUtilities.checkResult(decCopyReqMsg.extendedHeader().equals(reqMsg.extendedHeader()));
	     TestUtilities.EmaDecode_UPAFilterListAll(decCopyReqMsg.attrib().filterList(), TestUtilities.EncodingTypeFlags.MESSAGE_TYPES);
	     TestUtilities.EmaDecode_UPAFilterListAll(decCopyReqMsg.payload().filterList(), TestUtilities.EncodingTypeFlags.MESSAGE_TYPES);
	     
	     System.out.println("\ttestReqMsg_EncodeUPAReqMsgWithFilterListTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode passed");
	}
	
	public void testReqMsg_EncodeUPAReqMsgWithSeriesTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode()
	{ 
	    int retVal;
		 
		TestUtilities.printTestHead("testReqMsg_EncodeUPAReqMsgWithSeriesTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode", "Encode ReqMsg with UPA for Series as attrib, payload, Encode it to another ReqMsg.");

        // Create a UPA Buffer to encode into
        com.thomsonreuters.upa.codec.Buffer buffer = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
        buffer.data(ByteBuffer.allocate(14000));
        
    	int majorVersion = Codec.majorVersion();  // This should be initialized to the MAJOR version of RWF being encoded
		int minorVersion = Codec.minorVersion();  // This should be initialized to the MINOR version of RWF being encoded
	
		// Create and clear iterator to prepare for encoding
		com.thomsonreuters.upa.codec.EncodeIterator encodeIter = CodecFactory.createEncodeIterator();
		encodeIter.clear();
	
		// Associate buffer and iterator and set proper protocol version information on iterator.
		if ((retVal = encodeIter.setBufferAndRWFVersion(buffer, majorVersion, minorVersion)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with setBufferAndRWFVersion. "
							+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		if ( ( retVal = TestUtilities.upa_EncodeRequestMsgAll(encodeIter, com.thomsonreuters.upa.codec.DataTypes.SERIES)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with TestUtilities.upa_EncodeRequestMsgAll(). "
					+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		 // Decode ReqMsg with EMA.
	     com.thomsonreuters.ema.access.ReqMsg reqMsg = JUnitTestConnect.createReqMsg();
	     JUnitTestConnect.setRsslData(reqMsg, buffer, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	    TestUtilities.EmaDecode_UPARequestMsgAll(reqMsg, com.thomsonreuters.upa.codec.DataTypes.SERIES);
	
	     com.thomsonreuters.ema.access.ReqMsg copyReqMsg = EmaFactory.createReqMsg();
	     
	     // Encode to another ReqMsg
	     copyReqMsg.extendedHeader(reqMsg.extendedHeader());
	     copyReqMsg.attrib(reqMsg.attrib().data());
	     copyReqMsg.payload(reqMsg.payload().data());
	     
	     com.thomsonreuters.ema.access.ReqMsg decCopyReqMsg = JUnitTestConnect.createReqMsg();
	     
	     JUnitTestConnect.setRsslData(decCopyReqMsg, copyReqMsg, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	     // Check result
	     TestUtilities.checkResult(decCopyReqMsg.extendedHeader().equals(reqMsg.extendedHeader()));
	     TestUtilities.EmaDecode_UPASeriesAll(decCopyReqMsg.attrib().series(), com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST);
	     TestUtilities.EmaDecode_UPASeriesAll(decCopyReqMsg.payload().series(), com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST);
	     
	     System.out.println("\ttestReqMsg_EncodeUPAReqMsgWithSeriesTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode passed");
	}
	
	public void testReqMsg_EncodeUPAReqMsgWithVectorTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode()
	{ 
	    int retVal;
		 
		TestUtilities.printTestHead("testReqMsg_EncodeUPAReqMsgWithVectorTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode", "Encode ReqMsg with UPA for Vector as attrib, payload, Encode it to another ReqMsg.");

        // Create a UPA Buffer to encode into
        com.thomsonreuters.upa.codec.Buffer buffer = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
        buffer.data(ByteBuffer.allocate(14000));
        
    	int majorVersion = Codec.majorVersion();  // This should be initialized to the MAJOR version of RWF being encoded
		int minorVersion = Codec.minorVersion();  // This should be initialized to the MINOR version of RWF being encoded
	
		// Create and clear iterator to prepare for encoding
		com.thomsonreuters.upa.codec.EncodeIterator encodeIter = CodecFactory.createEncodeIterator();
		encodeIter.clear();
	
		// Associate buffer and iterator and set proper protocol version information on iterator.
		if ((retVal = encodeIter.setBufferAndRWFVersion(buffer, majorVersion, minorVersion)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with setBufferAndRWFVersion. "
							+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		if ( ( retVal = TestUtilities.upa_EncodeRequestMsgAll(encodeIter, com.thomsonreuters.upa.codec.DataTypes.VECTOR)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with TestUtilities.upa_EncodeRequestMsgAll(). "
					+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		 // Decode ReqMsg with EMA.
	     com.thomsonreuters.ema.access.ReqMsg reqMsg = JUnitTestConnect.createReqMsg();
	     JUnitTestConnect.setRsslData(reqMsg, buffer, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	    TestUtilities.EmaDecode_UPARequestMsgAll(reqMsg, com.thomsonreuters.upa.codec.DataTypes.VECTOR);
	
	     com.thomsonreuters.ema.access.ReqMsg copyReqMsg = EmaFactory.createReqMsg();
	     
	     // Encode to another ReqMsg
	     copyReqMsg.extendedHeader(reqMsg.extendedHeader());
	     copyReqMsg.attrib(reqMsg.attrib().data());
	     copyReqMsg.payload(reqMsg.payload().data());
	     
	     com.thomsonreuters.ema.access.ReqMsg decCopyReqMsg = JUnitTestConnect.createReqMsg();
	     
	     JUnitTestConnect.setRsslData(decCopyReqMsg, copyReqMsg, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	     // Check result
	     TestUtilities.checkResult(decCopyReqMsg.extendedHeader().equals(reqMsg.extendedHeader()));
	     TestUtilities.EmaDecode_UPAVectorAll(decCopyReqMsg.attrib().vector(), com.thomsonreuters.upa.codec.DataTypes.ELEMENT_LIST);
	     TestUtilities.EmaDecode_UPAVectorAll(decCopyReqMsg.payload().vector(), com.thomsonreuters.upa.codec.DataTypes.ELEMENT_LIST);
	     
	     System.out.println("\ttestReqMsg_EncodeUPAReqMsgWithVectorTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode passed");
	}
	
	public void testReqMsg_EncodeUPARefreshWithMapTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode()
	{ 
	    int retVal;
		 
		TestUtilities.printTestHead("testReqMsg_EncodeUPARefreshWithMapTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode", "Encode ReqMsg with UPA for Map as attrib, payload, Encode it to another ReqMsg.");

        // Create a UPA Buffer to encode into
        com.thomsonreuters.upa.codec.Buffer buffer = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
        buffer.data(ByteBuffer.allocate(8192));
        
    	int majorVersion = Codec.majorVersion();  // This should be initialized to the MAJOR version of RWF being encoded
		int minorVersion = Codec.minorVersion();  // This should be initialized to the MINOR version of RWF being encoded
	
		// Create and clear iterator to prepare for encoding
		com.thomsonreuters.upa.codec.EncodeIterator encodeIter = CodecFactory.createEncodeIterator();
		encodeIter.clear();
	
		// Associate buffer and iterator and set proper protocol version information on iterator.
		if ((retVal = encodeIter.setBufferAndRWFVersion(buffer, majorVersion, minorVersion)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with setBufferAndRWFVersion. "
							+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		if ( ( retVal = TestUtilities.upa_EncodeRequestMsgAll(encodeIter, com.thomsonreuters.upa.codec.DataTypes.MAP)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with TestUtilities.upa_EncodeRequestMsgAll(). "
					+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		 // Decode ReqMsg with EMA.
	     com.thomsonreuters.ema.access.ReqMsg reqMsg = JUnitTestConnect.createReqMsg();
	     JUnitTestConnect.setRsslData(reqMsg, buffer, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	    TestUtilities.EmaDecode_UPARequestMsgAll(reqMsg, com.thomsonreuters.upa.codec.DataTypes.MAP);
	
	     com.thomsonreuters.ema.access.ReqMsg copyReqMsg = EmaFactory.createReqMsg();
	     
	     // Encode to another ReqMsg
	     copyReqMsg.extendedHeader(reqMsg.extendedHeader());
	     copyReqMsg.attrib(reqMsg.attrib().data());
	     copyReqMsg.payload(reqMsg.payload().data());
	     
	     com.thomsonreuters.ema.access.ReqMsg decCopyReqMsg = JUnitTestConnect.createReqMsg();
	     
	     JUnitTestConnect.setRsslData(decCopyReqMsg, copyReqMsg, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	     // Check result
	     TestUtilities.checkResult(decCopyReqMsg.extendedHeader().equals(reqMsg.extendedHeader()));
	     TestUtilities.EmaDecode_UPAMapKeyUIntAll(decCopyReqMsg.attrib().map(), com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST);
	     TestUtilities.EmaDecode_UPAMapKeyUIntAll(decCopyReqMsg.payload().map(), com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST);
	     
	     System.out.println("\ttestReqMsg_EncodeUPARefreshWithMapTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode passed");
	}
	
	public void testReqMsg_EncodeUPAReqMsgWithRefreshTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode()
	{ 
	    int retVal;
		 
		TestUtilities.printTestHead("testReqMsg_EncodeUPAReqMsgWithRefreshTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode", "Encode ReqMsg with UPA for RefreshMsg as attrib, payload. Encode it to another ReqMsg.");

        // Create a UPA Buffer to encode into
        com.thomsonreuters.upa.codec.Buffer buffer = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
        buffer.data(ByteBuffer.allocate(8192));
        
    	int majorVersion = Codec.majorVersion();  // This should be initialized to the MAJOR version of RWF being encoded
		int minorVersion = Codec.minorVersion();  // This should be initialized to the MINOR version of RWF being encoded
	
		// Create and clear iterator to prepare for encoding
		com.thomsonreuters.upa.codec.EncodeIterator encodeIter = CodecFactory.createEncodeIterator();
		encodeIter.clear();
	
		// Associate buffer and iterator and set proper protocol version information on iterator.
		if ((retVal = encodeIter.setBufferAndRWFVersion(buffer, majorVersion, minorVersion)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with setBufferAndRWFVersion. "
							+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		if ( ( retVal = TestUtilities.upa_EncodeRequestMsgAll(encodeIter, com.thomsonreuters.upa.codec.DataTypes.MSG)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with TestUtilities.upa_EncodeRequestMsgAll(). "
					+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		 // Decode ReqMsg with EMA.
	     com.thomsonreuters.ema.access.ReqMsg reqMsg = JUnitTestConnect.createReqMsg();
	     JUnitTestConnect.setRsslData(reqMsg, buffer, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	    TestUtilities.EmaDecode_UPARequestMsgAll(reqMsg, com.thomsonreuters.upa.codec.DataTypes.MSG);
	
	     com.thomsonreuters.ema.access.ReqMsg copyReqMsg = EmaFactory.createReqMsg();
	     
	     // Encode to another ReqMsg
	     copyReqMsg.extendedHeader(reqMsg.extendedHeader());
	     copyReqMsg.attrib(reqMsg.attrib().data());
	     copyReqMsg.payload(reqMsg.payload().data());
	     
	     com.thomsonreuters.ema.access.ReqMsg decCopyReqMsg = JUnitTestConnect.createReqMsg();
	     
	     JUnitTestConnect.setRsslData(decCopyReqMsg, copyReqMsg, Codec.majorVersion(), Codec.minorVersion(), TestUtilities.getDataDictionary(), null);
	     
	     // Check result
	     TestUtilities.checkResult(decCopyReqMsg.extendedHeader().equals(reqMsg.extendedHeader()));
	     TestUtilities.EmaDecode_UPARefreshMsgAll(decCopyReqMsg.attrib().refreshMsg(), com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST);
	     TestUtilities.EmaDecode_UPARefreshMsgAll(decCopyReqMsg.payload().refreshMsg(), com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST);
	     
	     System.out.println("\ttestReqMsg_EncodeUPAReqMsgWithRefreshTypeAsAttrib_Payload_EncodeEMA_ToAnotherReqMsg_EMADecode passed");
	}

	public void testRequestMsg_cloneIsNotSupportedFromTheEncodeSide()
	{
		TestUtilities.printTestHead("testRequestMsg_cloneIsNotSupportedFromTheEncodeSide", "cloning is not supported on encode side");
		ReqMsg msg = EmaFactory.createReqMsg()
				.domainType(EmaRdm.MMT_MARKET_PRICE);

		try {
			ReqMsg cloneMessage = EmaFactory.createReqMsg(msg);
			TestUtilities.checkResult(false, "Clone not supported  - exception expected: ");
		} catch ( OmmException excp ) {
			TestUtilities.checkResult(true, "Clone not supported  - exception expected: " +  excp.getMessage() );
			TestUtilities.checkResult(excp.getMessage().startsWith("Failed to clone empty encoded buffer"), "Clone not supported - exception text validated");
		}
	}

	public void testReqMsg_cloneMsgKeyWLScenario()
	{
		TestUtilities.printTestHead("testReqMsg_cloneMsgKeyWLScenario", "cloning for minimal ema req message");
		ReqMsg emaMsg = EmaFactory.createReqMsg();
		emaMsg.payload(TestMsgUtilities.createFiledListBodySample());

		JUnitTestConnect.getRsslData(emaMsg);
		/** @see com.thomsonreuters.upa.valueadd.reactor.WlItemHandler#callbackUser(String, com.thomsonreuters.upa.codec.Msg, MsgBase, WlRequest, ReactorErrorInfo) */
		JUnitTestConnect.setRsslMsgKeyFlag(emaMsg, true);
		ReqMsg emaClonedMsg = EmaFactory.createReqMsg(emaMsg);

		compareEmaReqMsgFields(emaMsg, emaClonedMsg, "check clone for minimal message");
		JUnitTestConnect.setRsslMsgKeyFlag(emaMsg, false);

		System.out.println("End EMA ReqMsg Clone msgKey");
		System.out.println();
	}

	public void testRequestMsg_clone()
	{
		TestUtilities.printTestHead("testRequestMsg_clone", "cloning for ema request message");
		
		com.thomsonreuters.upa.codec.Buffer fieldListBuf = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
		fieldListBuf.data(ByteBuffer.allocate(1024));

		com.thomsonreuters.upa.codec.DataDictionary dictionary = com.thomsonreuters.upa.codec.CodecFactory.createDataDictionary();
		TestUtilities.upa_encodeDictionaryMsg(dictionary);

		int retVal;
		System.out.println("Begin UPA FieldList Encoding");
		if ((retVal = TestUtilities.upa_EncodeFieldListAll(fieldListBuf, EncodingTypeFlags.PRIMITIVE_TYPES)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error encoding field list.");
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" + retVal
					+ ") encountered with TestUtilities.upa_EncodeFieldListAll.  " + "Error Text: "
					+ CodecReturnCodes.info(retVal));
			return;
		}
		System.out.println("End UPA FieldList Encoding");
		System.out.println();

		fieldListBuf.data(fieldListBuf.data(),  0,  fieldListBuf.length());
		
	    System.out.println("Begin UPA RequestMsg Set");
		com.thomsonreuters.upa.codec.RequestMsg requestMsg = (com.thomsonreuters.upa.codec.RequestMsg)com.thomsonreuters.upa.codec.CodecFactory.createMsg();
		requestMsg.msgClass(com.thomsonreuters.upa.codec.MsgClasses.REQUEST);
		
		requestMsg.domainType( com.thomsonreuters.upa.rdm.DomainTypes.MARKET_PRICE );
		
		requestMsg.streamId( 15 );

		requestMsg.applyHasPriority();
		requestMsg.priority().priorityClass(5);
		requestMsg.priority().count(7);
			
		requestMsg.applyHasQos();
		requestMsg.qos().timeliness(QosTimeliness.REALTIME);
		requestMsg.qos().rate(QosRates.TICK_BY_TICK);

		requestMsg.msgKey().applyHasServiceId();
		requestMsg.msgKey().serviceId(5);
		
		requestMsg.msgKey().applyHasName();
		requestMsg.msgKey().name().data("ABCDEF");
		
		requestMsg.msgKey().filter(12);
		
		requestMsg.msgKey().identifier(21);
		
		requestMsg.msgKey().applyHasAttrib();
		requestMsg.msgKey().attribContainerType( com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST );
		requestMsg.msgKey().encodedAttrib(fieldListBuf);
		
		requestMsg.containerType(com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST);
		requestMsg.encodedDataBody(fieldListBuf);

		setMoreFields(requestMsg);

		System.out.println("End UPA RequestMsg Set");
		System.out.println();

		System.out.println("Begin UPA RequestMsg Buffer Encoding");

		com.thomsonreuters.upa.codec.Buffer msgBuf = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
		msgBuf.data(ByteBuffer.allocate(2048));
		
		com.thomsonreuters.upa.codec.EncodeIterator encIter = com.thomsonreuters.upa.codec.CodecFactory.createEncodeIterator();
		encIter.clear();
		int majorVersion = Codec.majorVersion();
		int minorVersion = Codec.minorVersion();
		if ((retVal = encIter.setBufferAndRWFVersion(msgBuf, majorVersion, minorVersion)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with setBufferAndRWFVersion. "
							+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		requestMsg.encode(encIter);
		
		System.out.println("End UPA RequestMsg Buffer Encoding");
		System.out.println();
		
		System.out.println("Begin EMA RequestMsg Clone");
		com.thomsonreuters.upa.codec.RequestMsg requestMsgDecode = (com.thomsonreuters.upa.codec.RequestMsg)com.thomsonreuters.upa.codec.CodecFactory.createMsg();

		com.thomsonreuters.upa.codec.DecodeIterator decIter = com.thomsonreuters.upa.codec.CodecFactory.createDecodeIterator();
		decIter.setBufferAndRWFVersion(msgBuf, majorVersion, minorVersion);
		requestMsgDecode.decode(decIter);

		com.thomsonreuters.ema.access.ReqMsg emaRequestMsg = JUnitTestConnect.createReqMsg();
				
		JUnitTestConnect.setRsslData(emaRequestMsg, requestMsgDecode, majorVersion, minorVersion, dictionary, null);
		
		com.thomsonreuters.ema.access.ReqMsg emaRequestMsgClone = EmaFactory.createReqMsg(emaRequestMsg);
		
		compareEmaReqMsgFields(emaRequestMsg, emaRequestMsgClone, "Request clone message");

		String emaRequestMsgString = emaRequestMsg.toString();
		String emaRequestMsgCloneString = emaRequestMsgClone.toString();
		
		System.out.println("Cloned EMA RequestMsg:");
		System.out.println(emaRequestMsgClone);
		
		TestUtilities.checkResult(emaRequestMsgString.equals(emaRequestMsgCloneString), "emaRequestMsgString.equals(emaRequestMsgCloneString)");

		com.thomsonreuters.ema.access.ReqMsg emaRequestMsgClone2 = EmaFactory.createReqMsg(emaRequestMsgClone);
		compareEmaReqMsgFields(emaRequestMsg, emaRequestMsgClone2, "Request double-cloned message");
		String emaRequestMsgClone2String = emaRequestMsgClone2.toString();
		TestUtilities.checkResult(emaRequestMsgString.equals(emaRequestMsgClone2String), "double-cloned emaRequestMsgString.equals(emaRequestMsgClone2String)");

		System.out.println("End EMA RequestMsg Clone");
		System.out.println();
	}

	private void setMoreFields(com.thomsonreuters.upa.codec.RequestMsg requestMsg) {
		requestMsg.applyHasExtendedHdr();
		Buffer extendedHeader = CodecFactory.createBuffer();
		extendedHeader.data(ByteBuffer.wrap(new byte[] {5, -6, 7, -8}));
		requestMsg.extendedHeader(extendedHeader);

		requestMsg.applyPrivateStream();
	}

	public void testRequestMsg_cloneEdit()
	{
		TestUtilities.printTestHead("testRequestMsg_cloneEdit", "clone and edit ema request message");
		
		com.thomsonreuters.upa.codec.Buffer fieldListBuf = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
		fieldListBuf.data(ByteBuffer.allocate(1024));

		com.thomsonreuters.upa.codec.DataDictionary dictionary = com.thomsonreuters.upa.codec.CodecFactory.createDataDictionary();
		TestUtilities.upa_encodeDictionaryMsg(dictionary);

		int retVal;
		System.out.println("Begin UPA FieldList Encoding");
		if ((retVal = TestUtilities.upa_EncodeFieldListAll(fieldListBuf, EncodingTypeFlags.PRIMITIVE_TYPES)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error encoding field list.");
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" + retVal
					+ ") encountered with TestUtilities.upa_EncodeFieldListAll.  " + "Error Text: "
					+ CodecReturnCodes.info(retVal));
			return;
		}
		System.out.println("End UPA FieldList Encoding");
		System.out.println();

		fieldListBuf.data(fieldListBuf.data(),  0,  fieldListBuf.length());
		
	    System.out.println("Begin UPA RequestMsg Set");
		com.thomsonreuters.upa.codec.RequestMsg requestMsg = (com.thomsonreuters.upa.codec.RequestMsg)com.thomsonreuters.upa.codec.CodecFactory.createMsg();
		requestMsg.msgClass(com.thomsonreuters.upa.codec.MsgClasses.REQUEST);
		
		requestMsg.domainType( com.thomsonreuters.upa.rdm.DomainTypes.MARKET_PRICE );
		
		requestMsg.streamId( 15 );

		requestMsg.applyHasPriority();
		requestMsg.priority().priorityClass(5);
		requestMsg.priority().count(7);
			
		requestMsg.applyHasQos();
		requestMsg.qos().timeliness(QosTimeliness.REALTIME);
		requestMsg.qos().rate(QosRates.TICK_BY_TICK);

		requestMsg.msgKey().applyHasServiceId();
		requestMsg.msgKey().serviceId(5);
		
		requestMsg.msgKey().applyHasName();
		requestMsg.msgKey().name().data("ABCDEF");
		
		requestMsg.msgKey().filter(12);
		
		requestMsg.msgKey().identifier(21);
		
		requestMsg.msgKey().applyHasAttrib();
		requestMsg.msgKey().attribContainerType( com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST );
		requestMsg.msgKey().encodedAttrib(fieldListBuf);
		
		requestMsg.containerType(com.thomsonreuters.upa.codec.DataTypes.FIELD_LIST);
		requestMsg.encodedDataBody(fieldListBuf);

		System.out.println("End UPA RequestMsg Set");
		System.out.println();

		System.out.println("Begin UPA RequestMsg Buffer Encoding");

		com.thomsonreuters.upa.codec.Buffer msgBuf = com.thomsonreuters.upa.codec.CodecFactory.createBuffer();
		msgBuf.data(ByteBuffer.allocate(2048));
		
		com.thomsonreuters.upa.codec.EncodeIterator encIter = com.thomsonreuters.upa.codec.CodecFactory.createEncodeIterator();
		encIter.clear();
		int majorVersion = Codec.majorVersion();
		int minorVersion = Codec.minorVersion();
		if ((retVal = encIter.setBufferAndRWFVersion(msgBuf, majorVersion, minorVersion)) < CodecReturnCodes.SUCCESS)
		{
			System.out.println("Error " + CodecReturnCodes.toString(retVal) + "(" +retVal + " encountered with setBufferAndRWFVersion. "
							+ " Error Text: " + CodecReturnCodes.info(retVal)); 
			return;
		}
		
		requestMsg.encode(encIter);
		
		System.out.println("End UPA RequestMsg Buffer Encoding");
		System.out.println();
		
		System.out.println("Begin EMA RequestMsg Clone");
		com.thomsonreuters.upa.codec.RequestMsg requestMsgDecode = (com.thomsonreuters.upa.codec.RequestMsg)com.thomsonreuters.upa.codec.CodecFactory.createMsg();

		com.thomsonreuters.upa.codec.DecodeIterator decIter = com.thomsonreuters.upa.codec.CodecFactory.createDecodeIterator();
		decIter.setBufferAndRWFVersion(msgBuf, majorVersion, minorVersion);
		requestMsgDecode.decode(decIter);

		com.thomsonreuters.ema.access.ReqMsg emaRequestMsg = JUnitTestConnect.createReqMsg();
				
		JUnitTestConnect.setRsslData(emaRequestMsg, requestMsgDecode, majorVersion, minorVersion, dictionary, null);
		
		com.thomsonreuters.ema.access.ReqMsg emaRequestMsgClone = EmaFactory.createReqMsg(emaRequestMsg);
		
		TestUtilities.checkResult(emaRequestMsgClone.domainType() == emaRequestMsg.domainType(), "Compare domainType");
		TestUtilities.checkResult(emaRequestMsgClone.streamId() == emaRequestMsg.streamId(), "Compare streamId");
		TestUtilities.checkResult(emaRequestMsgClone.hasPriority() == emaRequestMsg.hasMsgKey(), "Compare hasPriority");
		TestUtilities.checkResult(emaRequestMsgClone.priorityClass() == emaRequestMsg.priorityClass(), "Compare priorityClass");
		TestUtilities.checkResult(emaRequestMsgClone.priorityCount() == emaRequestMsg.priorityCount(), "Compare priorityCount");

		TestUtilities.checkResult(emaRequestMsgClone.hasQos() == emaRequestMsg.hasQos(), "Compare hasQos");
		TestUtilities.checkResult(emaRequestMsgClone.qosTimeliness() == emaRequestMsg.qosTimeliness(), "Compare qosTimeliness");
		TestUtilities.checkResult(emaRequestMsgClone.qosRate() == emaRequestMsg.qosRate(), "Compare qosRate");
		
		TestUtilities.checkResult(emaRequestMsgClone.hasMsgKey() == emaRequestMsg.hasMsgKey(), "Compare hasMsgKey");
		
		String emaRequestMsgString = emaRequestMsg.toString();
		String emaRequestMsgCloneString = emaRequestMsgClone.toString();
		
		System.out.println("Cloned EMA RequestMsg:");
		System.out.println(emaRequestMsgClone);
		
		TestUtilities.checkResult(emaRequestMsgString.equals(emaRequestMsgCloneString), "emaRequestMsgString.equals(emaRequestMsgCloneString)");
		
		emaRequestMsgClone.streamId(10);
		emaRequestMsgClone.payload().fieldList().add(EmaFactory.createFieldEntry().real(21, 3900, OmmReal.MagnitudeType.EXPONENT_NEG_2));

		TestUtilities.checkResult(emaRequestMsgClone.streamId() != emaRequestMsg.streamId(), "Compare streamId");

		// Check emaRequestMsg for no FID 21
		Iterator<FieldEntry> iter = emaRequestMsg.payload().fieldList().iterator();
		FieldEntry fieldEntry;
		while (iter.hasNext())
		{
			fieldEntry = iter.next();
			TestUtilities.checkResult(fieldEntry.fieldId() != 21, "Check emaRequestMsg for no FID 21");
		}
		
		boolean foundFid = false;
		Iterator<FieldEntry> iterClone = emaRequestMsgClone.payload().fieldList().iterator();
		while (iterClone.hasNext())
		{
			fieldEntry = iterClone.next();
			if(foundFid = fieldEntry.fieldId() == 21)
				break;
		}
		
		TestUtilities.checkResult(foundFid, "Check emaRequestMsgClone for FID 21");
		
		emaRequestMsgString = emaRequestMsg.toString();
		emaRequestMsgCloneString = emaRequestMsgClone.toString();
		
		TestUtilities.checkResult(!emaRequestMsgString.equals(emaRequestMsgCloneString), "Check that emaRequestMsgString does not equal emaRequestMsgCloneString");
		
		
		System.out.println("End EMA RequestMsg Clone");
		System.out.println();
	}

	private void compareEmaReqMsgFields(com.thomsonreuters.ema.access.ReqMsg expected, com.thomsonreuters.ema.access.ReqMsg actual, String checkPrefix) {
		TestMsgUtilities.compareMsgFields(expected, actual, checkPrefix + " base message");
		checkPrefix = checkPrefix + " compare: ";

		TestUtilities.checkResult(expected.hasServiceName() == actual.hasServiceName(), checkPrefix + "hasServiceName");
		if(expected.hasServiceName())
			TestUtilities.checkResult(expected.serviceName().equals(actual.serviceName()), checkPrefix + "serviceId" + "exp=" +actual.serviceName() + " act="+expected.serviceName());

		TestUtilities.checkResult(expected.privateStream() == actual.privateStream(), checkPrefix + "privateStream");

		TestUtilities.checkResult(expected.hasQos() == actual.hasQos(), checkPrefix + "hasQos");
		if(expected.hasQos()) {
			TestUtilities.checkResult(expected.qosRate() == actual.qosRate(), checkPrefix + "qosRate");
			TestUtilities.checkResult(expected.qosTimeliness() == actual.qosTimeliness(), checkPrefix + "qosTimeliness");
		}

		TestUtilities.checkResult(expected.hasPriority() == actual.hasPriority(), checkPrefix + "hasPriority");
		if(expected.hasPriority()) {
			TestUtilities.checkResult(expected.priorityClass() == actual.priorityClass(), checkPrefix + "priorityClass");
			TestUtilities.checkResult(expected.priorityCount() == actual.priorityCount(), checkPrefix + "priorityCount");
		}
	}
}

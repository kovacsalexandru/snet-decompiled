package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.firstparty.shared.CaptchaSolution;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.wireless.android.play.playlog.proto.UserLocation.OvenFreshEvent.OvenFreshResult;
import com.google.wireless.android.play.playlog.proto.UserLocation.TimeSelection.Type;

public class GplusInfoRequestCreator implements Creator<GplusInfoRequest> {
    public static final int CONTENT_DESCRIPTION = 0;

    public GplusInfoRequest createFromParcel(Parcel parcel) {
        int end = SafeParcelReader.validateObjectHeader(parcel);
        int _local_safe_0a1b_version = 0;
        String _local_safe_0a1b_accountName = null;
        CaptchaSolution _local_safe_0a1b_optionalCaptchaSolution = null;
        Account _local_safe_0a1b_account = null;
        while (parcel.dataPosition() < end) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case Type.TEMPORARY /*1*/:
                    _local_safe_0a1b_version = SafeParcelReader.readInt(parcel, header);
                    break;
                case Type.INDEFINITELY /*2*/:
                    _local_safe_0a1b_accountName = SafeParcelReader.createString(parcel, header);
                    break;
                case Type.CUSTOM /*3*/:
                    _local_safe_0a1b_optionalCaptchaSolution = (CaptchaSolution) SafeParcelReader.createParcelable(parcel, header, CaptchaSolution.CREATOR);
                    break;
                case OvenFreshResult.NO_ACCOUNTS /*4*/:
                    _local_safe_0a1b_account = (Account) SafeParcelReader.createParcelable(parcel, header, Account.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        if (parcel.dataPosition() == end) {
            return new GplusInfoRequest(_local_safe_0a1b_version, _local_safe_0a1b_accountName, _local_safe_0a1b_optionalCaptchaSolution, _local_safe_0a1b_account);
        }
        throw new ParseException("Overread allowed size end=" + end, parcel);
    }

    public GplusInfoRequest[] newArray(int size) {
        return new GplusInfoRequest[size];
    }

    static void writeToParcel(GplusInfoRequest obj, Parcel parcel, int flags) {
        int myStart = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, obj.version);
        SafeParcelWriter.writeString(parcel, 2, obj.accountName, false);
        SafeParcelWriter.writeParcelable(parcel, 3, obj.optionalCaptchaSolution, flags, false);
        SafeParcelWriter.writeParcelable(parcel, 4, obj.account, flags, false);
        SafeParcelWriter.finishObjectHeader(parcel, myStart);
    }
}

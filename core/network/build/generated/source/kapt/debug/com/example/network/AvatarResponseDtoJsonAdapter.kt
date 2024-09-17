// Code generated by moshi-kotlin-codegen. Do not edit.
@file:Suppress("DEPRECATION", "unused", "UNUSED_PARAMETER", "ClassName", "REDUNDANT_PROJECTION",
    "RedundantExplicitType", "LocalVariableName", "RedundantVisibilityModifier",
    "PLATFORM_CLASS_MAPPED_TO_KOTLIN", "IMPLICIT_NOTHING_TYPE_ARGUMENT_IN_RETURN_POSITION")

package com.example.network

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.Moshi
import com.squareup.moshi.`internal`.Util
import java.lang.NullPointerException
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.emptySet
import kotlin.text.buildString

public class AvatarResponseDtoJsonAdapter(
  moshi: Moshi,
) : JsonAdapter<AvatarResponseDto>() {
  private val options: JsonReader.Options = JsonReader.Options.of("login", "avatar_url", "name",
      "company", "bio")

  private val stringAdapter: JsonAdapter<String> = moshi.adapter(String::class.java, emptySet(),
      "login")

  public override fun toString(): String = buildString(39) {
      append("GeneratedJsonAdapter(").append("AvatarResponseDto").append(')') }

  public override fun fromJson(reader: JsonReader): AvatarResponseDto {
    var login: String? = null
    var url: String? = null
    var name: String? = null
    var company: String? = null
    var bio: String? = null
    reader.beginObject()
    while (reader.hasNext()) {
      when (reader.selectName(options)) {
        0 -> login = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("login", "login",
            reader)
        1 -> url = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("url", "avatar_url",
            reader)
        2 -> name = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("name", "name",
            reader)
        3 -> company = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("company",
            "company", reader)
        4 -> bio = stringAdapter.fromJson(reader) ?: throw Util.unexpectedNull("bio", "bio", reader)
        -1 -> {
          // Unknown name, skip it.
          reader.skipName()
          reader.skipValue()
        }
      }
    }
    reader.endObject()
    return AvatarResponseDto(
        login = login ?: throw Util.missingProperty("login", "login", reader),
        url = url ?: throw Util.missingProperty("url", "avatar_url", reader),
        name = name ?: throw Util.missingProperty("name", "name", reader),
        company = company ?: throw Util.missingProperty("company", "company", reader),
        bio = bio ?: throw Util.missingProperty("bio", "bio", reader)
    )
  }

  public override fun toJson(writer: JsonWriter, value_: AvatarResponseDto?): Unit {
    if (value_ == null) {
      throw NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.")
    }
    writer.beginObject()
    writer.name("login")
    stringAdapter.toJson(writer, value_.login)
    writer.name("avatar_url")
    stringAdapter.toJson(writer, value_.url)
    writer.name("name")
    stringAdapter.toJson(writer, value_.name)
    writer.name("company")
    stringAdapter.toJson(writer, value_.company)
    writer.name("bio")
    stringAdapter.toJson(writer, value_.bio)
    writer.endObject()
  }
}
